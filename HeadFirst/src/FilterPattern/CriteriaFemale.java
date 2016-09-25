package FilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwy on 2016/4/14.
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePerson = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("female"))
                femalePerson.add(person);
        }
        return femalePerson;
    }
}
