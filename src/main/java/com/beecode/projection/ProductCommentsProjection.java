package com.beecode.projection;

public interface ProductCommentsProjection {
	
	String getComment();
	int getScore();
	String getDateTimeComment();
	UserProjection getUser();
	
	public interface UserProjection {
		Long getId();
		PersonProjection getPerson();
		public interface PersonProjection {
			String getFirstName();
			String getLastName();
		}
	}
}
