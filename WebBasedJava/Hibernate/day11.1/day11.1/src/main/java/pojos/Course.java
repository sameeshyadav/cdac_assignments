package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course extends BaseEntity {
private String title;
private int capacity;
private double fees;
private LocalDate startDate;
private LocalDate endDate;
private List<Student> Student=new ArrayList<>();
public Course() {
	
}
}
