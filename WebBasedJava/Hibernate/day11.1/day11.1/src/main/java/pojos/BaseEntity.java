package pojos;
import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
	private Integer id;	

	public BaseEntity() 
	{
		System.out.println("In base ent constructor");
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
