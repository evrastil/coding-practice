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
            add("Skill6");
            add("Skill3");
        }});
        peopleWithSkills.put("Person2", new ArrayList<String>() {{
            add("Skill2");
            add("Skill4");
            add("Skill3");
        }});
        peopleWithSkills.put("Person3", new ArrayList<String>() {{
            add("Skill1");
            add("Skill2");
            add("Skill5");
        }});

        List<String> res1 = findPeopleWithSkill("Skill1", peopleWithSkills);
        System.out.println(res1);
        List<String> res2 = findPeopleWithSkills(new ArrayList<String>() {{
            add("Skill1");
            add("Skill2");
        }}, peopleWithSkills);
        System.out.println(res2);

        Map<String, List<String>> teamsWithSkills = createTeamsWithSkills(new ArrayList<String>() {{
            add("Skill1");
            add("Skill2");
        }}, peopleWithSkills);
        System.out.println(teamsWithSkills);
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
    /*
    * May be not correct.
    */

    public Map<String, List<String>> createTeamsWithSkills(List<String> expectedSkillsInTeam, Map<String, List<String>> peopleWithSkills) {
        Map<String, List<String>> teams = new HashMap<>();
        Map<String, Integer> people = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : peopleWithSkills.entrySet()) {
            for (String skill : expectedSkillsInTeam) {
                for (String s : entry.getValue()) {
                    if (s.equals(skill)) {
                        if (people.containsKey(entry.getKey())) {
                            people.put(entry.getKey(), people.get(entry.getKey()) + 1);
                        } else {
                            people.put(entry.getKey(), 1);
                        }
                    }
                }
            }
        }
        int teamCount = 0;
        for (Integer skillCount : people.values()) {
            teamCount += skillCount;
        }

        for (int i = 1; i <= teamCount; i++) {
            teams.put("team" + i, new ArrayList<>());
        }

        for (Map.Entry<String, Integer> c : people.entrySet()) {
            for (Map.Entry<String, List<String>> team : teams.entrySet()) {
                team.getValue().add(c.getKey());
            }
        }

        return teams;
    }


}
