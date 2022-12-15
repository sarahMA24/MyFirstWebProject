package MSP;

public class SubjectAndName {
	private String subjectes;
	private String classes;
	public SubjectAndName(String subjectes,String classes) {
		this.subjectes=subjectes;
		this.classes=classes;
	}

	public String getSubjectes() {
		return subjectes;
	}

	public String getClasses() {
		return classes;
	}

	public void setSubjectes(String s) {
		subjectes=s;
	}
	public void setClasses(String c) {
		classes=c;
	}
	
}
