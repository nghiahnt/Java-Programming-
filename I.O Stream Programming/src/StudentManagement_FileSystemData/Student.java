package StudentManagement_FileSystemData;

public class Student implements Comparable<Object> {
	private String name;
	private String id;
	private float aver;
	
	public Student() {
		name = new String("");
		id = new String("");
		aver = 0;
	}
	
	public Student(String name, String id, float aver) {
		this.name = name;
		this.id = id;
		this.aver = aver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getAver() {
		return aver;
	}

	public void setAver(float aver) {
		this.aver = aver;
	}
	
	public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", aver=" + aver +
                '}';
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
