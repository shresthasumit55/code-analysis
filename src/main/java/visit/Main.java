package visit;

import visit.exception.*;

import java.util.ArrayList;
import java.util.List;


public class Main {


	private static void test(){
		String[] field = {"b", "a", "y", "l", "o", "r"};

		String s = "";

		for (int i = 0; i < field.length; ++i) {
			s = s + field[i];
		}
		List<String> names = new ArrayList<String>();
		System.out.println(s);


		/*
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < field.length; ++i) {
			sb.append(field[i]);
		}
		s = sb.toString();
		*/
		System.out.println(s);

	}
	
	
	public static void madMethod() throws AuthorizationException, BusinessRuleViolation, DuplicateEntityViolation, SearchException, SystemError {
		//test();
		double seed = Math.random();
		seed = 5;
		int temp;

		for (int i=0;i<20;){
			temp = i;
		}

		if (seed == 0.15) {
			throw new AuthorizationException(AuthorizationException.Type.ACCESS_DENIED, new Exception("User crab not allowed"));
		} else if (seed < 0.3) {
			throw new DuplicateEntityViolation("Duplicate issue", new NamedEntity());
		} else if (seed < 0.45) {
			throw new BusinessRuleViolation("Holy crab", BusinessRuleViolation.BusinessRule.FEE_TOO_SMALL, new NamedEntity());
		} else if (seed < 0.6) {
			throw new SearchException("Holy moly query");
		} else if (seed < 0.75) {
			throw new SystemError("Gosh", new Exception("Crab error"), visit.exception.SystemError.Type.TRANSIENT_INSTANCE);
		} 
		System.out.println("Yupee");
	}
	
	/**
	 * Can I simplify this somehow via Visitor?
	 * 
	 * You can expect only there exceptions to show up
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			madMethod();
		} catch (AuthorizationException e) {
			System.err.println(e.getErrorName() + " " + e.getType());
			e.printStackTrace();
		} catch (BusinessRuleViolation e) {
			System.err.println(e.getErrorName() + " " + e.getBusinessRuleViolated() + " " + e.getCauser().getClass().getSimpleName());
			e.printStackTrace();
		} catch (DuplicateEntityViolation e) {
			System.err.println(e.getErrorName() + " " + e.getDuplicatedEntity().getName());
			e.printStackTrace();
		} catch (SearchException e) {
			System.err.println(e.getErrorName() + " " + e.getMessage());
			e.printStackTrace();
		} catch (SystemError e) {
			System.err.println("Unexpected error" + e.getErrorName() + " " + e.getType());
			e.printStackTrace();
		}
	}
}
