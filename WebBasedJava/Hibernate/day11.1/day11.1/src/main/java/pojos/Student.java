package pojos;
import javax.persistence.*;
@Entity
@Table(name="student_tbl")
public class Student extends BaseEntity {
	@Column(length=20)
	private String name;
	private String email;
	private Course selectedCourse;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Course getSelectedCourse() {
		return selectedCourse;
	}
	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}
	public Student() {
		 System.out.println("In student Constructor");
	 }
	@Override
	public String toString() {
		return "Student id="+getId()+" [name=" + name + ", email=" + email + "]";
	}
	 
}
