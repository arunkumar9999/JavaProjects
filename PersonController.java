package com.hcl.controller;

public class PersonController {
	
private PersonService personService;

	

	@Autowired(required=true)

	@Qualifier(value="personService")

	public void setPersonService(PersonService ps){

		this.personService = ps;

	}

	

	@RequestMapping(value = "/persons", method = RequestMethod.GET)

	public String listPersons(Model model) {

		model.addAttribute("person", new Person());

		model.addAttribute("listPersons", this.personService.listPersons());

		return "person";

	}

	

	//For add and update person both

	@RequestMapping(value= "/person/add", method = RequestMethod.POST)

	public String addPerson(@ModelAttribute("person") Person p){

		

		if(p.getId() == 0){

			//new person, add it

			this.personService.addPerson(p);

		}else{

			//existing person, call update

			this.personService.updatePerson(p);

		}

		

		return "redirect:/persons";

		

	}

	

	@RequestMapping("/remove/{id}")

    public String removePerson(@PathVariable("id") int id){

		

        this.personService.removePerson(id);

        return "redirect:/persons";

    }

 

    @RequestMapping("/edit/{id}")

    public String editPerson(@PathVariable("id") int id, Model model){

        model.addAttribute("person", this.personService.getPersonById(id));

        model.addAttribute("listPersons", this.personService.listPersons());

        return "person";

    }

	

}