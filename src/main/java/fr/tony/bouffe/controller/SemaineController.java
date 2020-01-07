package fr.tony.bouffe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.tony.bouffe.modele.Semaine;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/semaine")
public class SemaineController {
	private List<Semaine> jourSemaine = new ArrayList<>();
	
	public SemaineController() {
		Semaine lundi = new Semaine("lundi", 1);
		Semaine mardi = new Semaine("mardi", 2);
		Semaine mercredi = new Semaine("mercredi", 3);
		Semaine jeudi = new Semaine("jeudi", 4);
		Semaine vendredi = new Semaine("vendredi", 5);
		Semaine samedi = new Semaine("samedi", 6);
		Semaine dimanche = new Semaine("dimanche", 7);	
		
		this.jourSemaine.add(lundi);
		this.jourSemaine.add(mardi);
		this.jourSemaine.add(mercredi);
		this.jourSemaine.add(jeudi);
		this.jourSemaine.add(vendredi);
		this.jourSemaine.add(samedi);
		this.jourSemaine.add(dimanche);
	}
	
	@RequestMapping("/jourList")
	public List<Semaine>getAll() {
		return jourSemaine;
		
	}
	
	@GetMapping("/jour{id}")
	public ResponseEntity<Semaine> selectedDay(@RequestParam(value="id") int id){
		for (Semaine semaine : jourSemaine) {
			if (semaine.getId()==id) {
				return new ResponseEntity<Semaine>(semaine,HttpStatus.OK);
			}
		}
		return ResponseEntity.notFound().build();
	}
}
