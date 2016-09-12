package FilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwy on 2016/4/14.
 */
public class CriteriaSingle implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePerson = new ArrayList<>();
        for(Person person:persons){
            if(person.getMaritalStatus().equalsIgnoreCase("single"))
                singlePerson.add(person);
        }
        return singlePerson;
    }
}
