package ca.sheridancollege.javiersh.beans;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Course {
	
	@NonNull
	private int id;
	
	private String prefix;
	private int code;
	private String name;


//	public Course(long id, String prefix, int code, String name) {
//		super();
//		this.id = id;
//		this.prefix = prefix;
//		this.code = code;
//		this.name = name;
//	}

//	public Course() {
//		super();
//	}
//	
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public String getPrefix() {
//		return prefix;
//	}
//	public void setPrefix(String prefix) {
//		this.prefix = prefix;
//	}
//	public int getCode() {
//		return code;
//	}
//	public void setCode(int code) {
//		this.code = code;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	@Override
//	public String toString() {
//		return "Course [id=" + id + ", prefix=" + prefix + ", code=" + code + ", name=" + name + ", getId()=" + getId()
//				+ ", getPrefix()=" + getPrefix() + ", getCode()=" + getCode() + ", getName()=" + getName()
//				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
//				+ "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + code;
//		result = prime * result + (int) (id ^ (id >>> 32));
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Course other = (Course) obj;
//		if (code != other.code)
//			return false;
//		if (id != other.id)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (prefix == null) {
//			if (other.prefix != null)
//				return false;
//		} else if (!prefix.equals(other.prefix))
//			return false;
//		return true;
//	}
}
