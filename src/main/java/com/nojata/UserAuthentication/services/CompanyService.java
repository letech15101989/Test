/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.services;

import com.nojata.UserAuthentication.Util.RenadomNumberGenerator;
import com.nojata.UserAuthentication.model.entity.Aktivities;
import com.nojata.UserAuthentication.model.entity.Compnay;
import com.nojata.UserAuthentication.repositories.AktivitiesRepository;
import com.nojata.UserAuthentication.repositories.CompanyRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.nojata.UserAuthentication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Shamsher
 */
@Service
public class CompanyService {

    @Autowired
    CompanyRepository cr;
    @Autowired
    AktivitiesRepository ar;

    @Autowired
    UserRepository userRepo;

    public String saveCompany(String compName, String compAddr, byte[] logo) {
        String compId = RenadomNumberGenerator.generate(compName.substring(0, 2));
        Compnay compnay = new Compnay().builder().compName(compName).compAddress(compAddr).compCountry("INDIA").compId(compId).compPostalCode("2770").compLogo(logo).build();

        cr.save(compnay);
        return "saved";

    }

    public String updateCompany(String compId, String compName, String compAddr, byte[] logo) throws Exception {
        Optional<Compnay> compDetails = cr.findById(compId);
  System.out.println("com.nojata.UserAuthentication.services.CompanyService.updateCompany()" + compId);
        Compnay compnay = null;
        if (compDetails.isPresent()) {
            compnay = compDetails.get();
        } else {
            throw new Exception("No data found for company");
        }
        compnay.setCompName(compName);
        compnay.setCompAddress(compAddr);
        compnay.setCompLogo(logo.length > 0 ? logo : compnay.getCompLogo());

        System.out.println("Company updated");

        cr.save(compnay);
        return "saved";

    }

    public Compnay getCompany(String compId) {
        Optional<Compnay> compDetails = cr.findById(compId);
        if (compDetails.isPresent()) {
            return compDetails.get();
        } else {
            return null;
        }
    }

    public boolean deleteCompany(String compId) throws Exception {
        System.out.println("com.nojata.UserAuthentication.services.CompanyService.deleteCompany()" + compId);

        if (compId == null) {
            throw new Exception("Comp id is null");
        }

        cr.deleteById(compId);
        System.out.println("After delete");
        return true;
//            List<Compnay> compDetails =  cr.findAll();
//             List<Compnay> compDetails1 = compDetails.stream().filter(x->compId.equalsIgnoreCase(x.getCompName())).collect(Collectors.toList());
//           cr.deleteById(compId);
//            if(compDetails1.size() > 0){
//                String compId1= compDetails1.get(0).getCompId();
//                 cr.deleteById(compId1);
//                 return true;
//            } 
//            return false;
    }

    public List<Compnay> getAllCompany() {
        List<Compnay> compDetails = cr.findAll();

        return compDetails;
    }

    public List<Aktivities> getAllAktivities() {
        List<Aktivities> compDetails = ar.findAll();
        System.out.println("compDetails changed::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + compDetails);
        return compDetails;
    }

    public boolean createActivities(String id, String name, String shiftPlan, String userId) {
        Aktivities activity = new Aktivities();
        if(id!=null){
            activity = ar.findById(Integer.valueOf(id)).orElse(null);
            if(activity == null){
                System.out.println("data not found for id :"+id);
            }
        }
        activity.setName(name);
        activity.setShiftPlan(shiftPlan);
        activity.setUser(userRepo.getReferenceById(userId));
        System.out.println("compDetails changed::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + activity);
        ar.save(activity);
        return true;
    }
}
