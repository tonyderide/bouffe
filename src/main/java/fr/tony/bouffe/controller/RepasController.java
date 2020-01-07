package fr.tony.bouffe.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.tony.bouffe.modele.Repas;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/bouffe")
public class RepasController {
	private List<Repas> platList= new ArrayList<>();

	
	public RepasController(){
		
		Repas monPlat1 = new Repas(1,"burger","spaghetti bolognaise");
		Repas monPlat2 = new Repas(2,"gratin-dauphinois","burger");
		Repas monPlat3 = new Repas(3,"patte lardon","raclette");
		Repas monPlat4 = new Repas(4,"pizza truffe","patte lardon");
		Repas monPlat5 = new Repas(5,"poulet teriyaki","gratin-dauphinois");
		Repas monPlat6 = new Repas(6,"raclette","poulet teriyaki");
		Repas monPlat7 = new Repas(7,"spaghetti bolognaise","pizza truffe");
		this.platList.add(monPlat1);
		this.platList.add(monPlat2);
		this.platList.add(monPlat3);
		this.platList.add(monPlat4);
		this.platList.add(monPlat5);
		this.platList.add(monPlat6);
		this.platList.add(monPlat7);		
	}
	
	@RequestMapping("/titre")
	public String titre() {
		return "PROJET REPAS";
		
	}


	@GetMapping("/montrelesplats")
	public List<Repas> getAll(String jour) {
		return platList;
	}
	
	@RequestMapping("/ajoute")
	public Repas ajouteUnPlat(@RequestParam (value="id") int id,
							  @RequestParam (value="plat") String plat,
							  @RequestParam (value="plat2") String plat2) {
		Repas addPlat = new Repas(id,plat,plat2);
		platList.add(addPlat);
		return addPlat;	
	}
	
	@GetMapping("/objetPlat{id}")
	public ResponseEntity<Repas> recupePlat(@RequestParam(value="id") int id) {
		for (Repas repas : platList) {
			if (repas.getId()==id) {
				return new ResponseEntity<Repas>(repas,HttpStatus.OK);
			}
		}
		return ResponseEntity.notFound().build();
	}
	

}
