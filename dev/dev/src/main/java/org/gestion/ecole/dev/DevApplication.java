package org.gestion.ecole.dev;

import org.gestion.ecole.dev.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class DevApplication {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired
	private PaysRepository paysRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private ProvinceRepository provinceRepository;
	@Autowired
	private AdresseRepository adresseRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;

	public static void main(String[] args) {
		SpringApplication.run(DevApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		repositoryRestConfiguration.exposeIdsFor(Etudiant.class, Proffeseur.class, Matiere.class, Filliere.class);
//
//		Province p=provinceRepository.save(new Province(null,"RABAT"));
//		Adresse adr1=adresseRepository.save(new Adresse(null,"hay nakhil rabat","R",p));
//		Adresse adr2=adresseRepository.save(new Adresse(null,"yaakoub lmansour rabat","R",p));
//		regionRepository.save(new Region(null,"RABAT-SALE KENITRA"));
//		paysRepository.save(new Pays(null,"MAROC"));
//
//		etudiantRepository.save(new Etudiant(null,"tagguine","adil","adil@gmail.com","1234", Instant.parse("1988-10-23T10:12:35Z"),"0674635356","d:/photo/adil.jpeg","M",adr1));
//		etudiantRepository.save(new Etudiant(null,"ouhamza","houciene","houcine@gmail.com","1234", Instant.parse("1988-10-23T10:12:35Z"),"0674635356","d:/photo/houcine.jpeg","M",adr1));
//		etudiantRepository.save(new Etudiant(null,"bkal","zakis","zakis@gmail.com","1234", Instant.parse("1988-10-23T10:12:35Z"),"0674635356","d:/photo/zakis.jpeg","M",adr2));
//		etudiantRepository.save(new Etudiant(null,"bouganfou","lhoussaine","lhoussaine@gmail.com","1234", Instant.parse("1988-10-23T10:12:35Z"),"0674635356","d:/photo/lhoussaine.jpeg","M",adr2));
//
//
//
//	}
}
