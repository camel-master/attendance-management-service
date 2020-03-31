package org.sarang.attend.web;

import lombok.RequiredArgsConstructor;
import org.sarang.attend.config.auth.LoginUser;
import org.sarang.attend.config.auth.dto.SessionUser;
import org.sarang.attend.domain.user.Role;
import org.sarang.attend.service.posts.RolesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
@Controller
public class RoleManagementController {
    private final RolesService rolesService;

    @RequestMapping("/Roles")
    @ModelAttribute("roleValues")
    //public Collection<Role> roleTypes() {
    public void roleTypes() {
        Role[] arr_roleValues = Role.values();
        for(int i=0; i<arr_roleValues.length; i++) {
            System.out.println(arr_roleValues[i]);
        }

        //return new ArrayList<Role>(Arrays.asList(Role.values()));
    }

    @GetMapping("/Roles")
    public String roles(Model model, @LoginUser SessionUser user) {
        model.addAttribute("roles", rolesService.findAllDesc());
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "roles";
    }
}
