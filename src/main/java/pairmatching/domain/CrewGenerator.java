package pairmatching.domain;

public class CrewGenerator {

    public Crews generatorCrew() {
        Crews crews = new Crews();

        for(int i=0; i<crews.size(); i++) {
            Crew crew = new Crew(course, name);
            crews.addCrew(crew);
        }

        return crews;
    }
