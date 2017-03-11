package employee.jdbc.entity;

import employee.jdbc.base.BaseEntity;

public class EmployeeEntity extends BaseEntity{
	private String job;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
