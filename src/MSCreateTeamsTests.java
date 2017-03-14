import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Build teams
 * Napřed vyhledávání lidí, co mají daný skil
 * Pak hledání lidí, co mají seznam skillu
 * A nakonec sestavit týmy, které dohromady umí zadané skilly. Najít všechny kombinace, lidi se mohli v týmech opakovat myslím
 */
public class MSCreateTeamsTests {

    @Test
    public void testIt() {
        Map<String, List<String>> peopleWithSkills = new HashMap<String, List<String>>();
        peopleWithSkills.put("Person1", new ArrayList<String>() {{
            add("Skill1");
            add("Skill2");
            add("Skill3");
        }});
        peopleWithSkills.put("Person2", new ArrayList<String>() {{
            add("Skill1");
            add("Skill4");
            add("Skill3");
        }});
        peopleWithSkills.put("Person3", new ArrayList<String>() {{
            add("Skill2");
            add("Skill5");
        }});
        peopleWithSkills.put("Person4", new ArrayList<String>() {{
            add("Skill1");
        }});
        peopleWithSkills.put("Person5", new ArrayList<String>() {{
            add("Skill1");
            add("Skill2");
            add("Skill9");
        }});
        List<String> res1 = findPeopleWithSkill("Skill1", peopleWithSkills);
        System.out.println(res1);
        List<String> res2 = findPeopleWithSkills(new ArrayList<String>() {{
            add("Skill1");
            add("Skill2");
        }}, peopleWithSkills);
        System.out.println(res2);
    }

    public List<String> findPeopleWithSkill(String skill, Map<String, List<String>> peopleWithSkills) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : peopleWithSkills.entrySet()) {
            for (String s : entry.getValue()) {
                if (s.equals(skill)) {
                    result.add(entry.getKey());
                }
            }
        }
        return result;
    }

    public List<String> findPeopleWithSkills(List<String> expectedSkills, Map<String, List<String>> peopleWithSkills) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : peopleWithSkills.entrySet()) {
            List<String> skillMatch = new ArrayList<>();
            for (String peopleSkill : entry.getValue()) {
                for (String expectedSkill : expectedSkills) {
                    if (peopleSkill.equals(expectedSkill)) {
                        skillMatch.add(expectedSkill);
                    }
                }
            }
            if (skillMatch.size() == expectedSkills.size()) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public Map<String, List<String>> createTeamsWithSkills(List<String> expectedSkillsInTeam, Map<String, List<String>> peopleWithSkills) {
        Map<String, List<String>> teams = new HashMap<>();
        teams.put("team1", new ArrayList<>());
        List<String> people = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : peopleWithSkills.entrySet()) {
            for (String skill : expectedSkillsInTeam) {
                if (entry.getValue().contains(skill)) {
                    people.add(entry.getKey());
                }
            }
        }

        return teams;
    }


}
