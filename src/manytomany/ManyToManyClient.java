package manytomany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class ManyToManyClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();

		Student student = new Student();
		student.setSname("Vyshu");
		student.setMarks(800);

		Training t1 = new Training();
		t1.setTname("Java Training");
		t1.setTstartdate(LocalDate.now().plusDays(10));

		Training t2 = new Training();
		t2.setTname("Hibernate Training");
		t2.setTstartdate(LocalDate.now().plusDays(5));

		Set<Training> trainings = new HashSet<Training>();
		trainings.add(t2);
		trainings.add(t1);

		student.setTrainings(trainings);

		session.save(student);

		HibernateUtility.closeSession(null);
	}
}
