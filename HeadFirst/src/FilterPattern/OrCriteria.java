package FilterPattern;

import java.util.List;

/**
 * Created by lwy on 2016/4/14.
 */
public class OrCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        List<Person> secondCriteriaPersons = otherCriteria.meetCriteria(persons);

        for (Person person : secondCriteriaPersons) {
            if (!firstCriteriaPersons.contains(person))
                firstCriteriaPersons.add(person);
        }
        return firstCriteriaPersons;
    }
}
