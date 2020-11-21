package com.springdemo.controller;

import com.springdemo.entity.Country;
import com.springdemo.entity.Player;
import com.springdemo.entity.Team;
import com.springdemo.service.CountryService;
import com.springdemo.service.PlayerService;
import com.springdemo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private CountryService countryService;

    @Autowired
    private PlayerService playerService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public  String listTeams(Model model){

        List<Team> teams = teamService.getTeams();

        model.addAttribute("teams",teams);

        return "team-list";

    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        Team team = new Team();
        model.addAttribute("team",team);
        model.addAttribute("country_list",countryService.getCountries());
        return "team-form";
    }

    @PostMapping("/saveTeam")

    public String saveTeam(@Valid @ModelAttribute Team team , BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "team-form";
        }
        else{
            teamService.saveTeam(team);

            return "redirect:/team/list";
        }


    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("teamId") int id, Model model)
    {
        Team team = teamService.getTeamById(id);
        Country country = countryService.getCountryById(team.getCountry().getId());
        model.addAttribute("team",team);
        model.addAttribute("country_list",countryService.getCountries());
        return "team-update-form";
    }

    @GetMapping("/delete")
    public String deleteTeam(@RequestParam("teamId") int id)
    {
        teamService.deleteTeam(id);
        return "redirect:/team/list";
    }

    @GetMapping("/viewTeam")
    public String ViewTeam(@RequestParam("teamId") int id,Model model)
    {
      Team team = teamService.getTeamById(id);
      model.addAttribute("team", team);
        return "view-team";
    }

    @GetMapping("/addPlayerToTeam")
    public String addPlayerToTeam(@RequestParam("teamId") int id,Model model)
    {
        Team team = teamService.getTeamById(id);
        List<Player> players = playerService.getPlayers();
        Player player = new Player();
        model.addAttribute("team",team);
        model.addAttribute("player",player);
        model.addAttribute("players",players);

        return "add-player";
    }

    @PostMapping("/savePlayerToTeam")
    public String savePlayerToteam(@ModelAttribute Player player , RedirectAttributes redirectAttributes)
    {
        teamService.addPlayerToTeam(player.getId(),player.getTeam().getId());
         redirectAttributes.addAttribute("teamId",player.getTeam().getId());
        return "redirect:/team/viewTeam";
    }



    @PostMapping("/updateTeam")
    public String updateTeam(@Valid@ModelAttribute Team team , BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "team-update-form";
        }
        else {
            teamService.updateTeam(team);
            return "redirect:/team/list";
        }

    }






}
