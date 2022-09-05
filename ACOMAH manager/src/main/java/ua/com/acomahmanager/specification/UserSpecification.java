package ua.com.acomahmanager.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.acomahmanager.domain.User;
import ua.com.acomahmanager.domain.UserRole;

public class UserSpecification implements Specification<User> {

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String firstName;
	private String lastName;
	private String patronymic;
	private String street;
	private String building; 
	private String apartment;
	private String phoneNumber;
	private String zipCode;
	
	public UserSpecification(User user) {
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.patronymic = user.getPatronymic();
		this.street = user.getStreet();
		this.building = user.getBuilding();
		this.apartment = user.getApartment();
		this.phoneNumber = user.getPhoneNumber();
		this.zipCode = user.getZipCode();
	}

	public static Specification<User> textInAllColumns(String text) {
		if (!text.contains("%")) {
			text = "%" + text + "%";
		}
		final String finalText = text;

        return (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
        	Predicate orPredicate = criteriaBuilder.or(root.getModel()
                .getDeclaredSingularAttributes()
                .stream()
                .filter(a ->
                	!a.getName().equals("password") &&  //fields id, role, isDeleted, isActive will not be took into account 
                    !a.getName().equals("passwordConfirm") && 
                    a.getJavaType().getSimpleName().equalsIgnoreCase("string"))
                .map( a -> 
                  criteriaBuilder.like(root.get(a.getName()), finalText)              		
                ).toArray(Predicate[]::new)
        	);
        	
        	Predicate andPredicate = criteriaBuilder.equal(root.get("role"), UserRole.ROLE_USER);
        	Predicate isDeletedPredicate = criteriaBuilder.equal(root.get("isDeleted"), false);
//        	Predicate isActivePredicate = criteriaBuilder.equal(root.get("isActive"), true);
	   
	    	return criteriaBuilder.and(orPredicate, andPredicate, isDeletedPredicate /*, isActivePredicate*/);
        };
	}
	
	public static Specification<User> containsTextInName(String text) {
	    if (!text.contains("%")) {
	        text = "%" + text + "%";
	    }
	    String finalText = text;
	    return (root, query, builder) -> {
	    	Predicate orPredicate = builder.or(
	    		builder.like(root.get("email"), finalText),
	    		builder.like(root.get("firstName"), finalText),
	    		builder.like(root.get("lastName"), finalText),
	    		builder.like(root.get("patronymic"), finalText),
	    		builder.like(root.get("street"), finalText),
	    		builder.like(root.get("building"), finalText),
	    		builder.like(root.get("apartment"), finalText),
	    		builder.like(root.get("phoneNumber"), finalText),
	    		builder.like(root.get("zipCode"), finalText)); 
	    		
	    	Predicate andPredicate = builder.equal(root.get("role"), UserRole.ROLE_USER);
	    	Predicate isDeletedPredicate = builder.equal(root.get("isDeleted"), false);
//	    	Predicate isActivePredicate = builder.equal(root.get("isActive"), true);
	    	return builder.and(orPredicate, andPredicate, isDeletedPredicate/*, isActivePredicate*/);
	    };
	}

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		return null;
	}
	
	private Predicate findByFirstNameLike(Root<User> root, CriteriaBuilder cb) {
		Predicate predicate;
		
		if (firstName == null || this.firstName.trim().isEmpty()) {
			predicate = cb.conjunction();
		} else {
			predicate = cb.like(root.get("firstName"), "%" + this.firstName + "%");
		}
		
		return predicate;
	}
}