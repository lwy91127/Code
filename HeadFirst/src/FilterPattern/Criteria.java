package FilterPattern;

import java.util.List;

/**
 * Created by lwy on 2016/4/14.
 */
public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}
