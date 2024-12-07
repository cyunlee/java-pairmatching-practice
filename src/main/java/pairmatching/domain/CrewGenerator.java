package pairmatching.domain;

import java.util.List;
import pairmatching.util.FileParser;

public class CrewGenerator {
    private final FileParser fileParser = new FileParser();

    public List<String> parseNamesFromFile(String filePath) {
        return fileParser.parseFromFile(filePath);
    }

    public Crews generatorCrew() {
        Crews crews = new Crews();

        for(int i=0; i<crews.size(); i++) {
            Crew crew = new Crew(course, name);
            crews.addCrew(crew);
        }

        return crews;
    }
}

