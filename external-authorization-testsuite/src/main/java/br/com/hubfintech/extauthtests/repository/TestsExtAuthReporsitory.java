package br.com.hubfintech.extauthtests.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.hubfintech.extauthtests.model.TestModelReport;

@Repository
@Transactional("txExternalAuthTestSuite")
public class TestsExtAuthReporsitory implements ITestsExtAuthReporsitory {

	//@PersistenceContext(unitName = "extauthtests")
	//@Qualifier("emfext")
	private EntityManager em;

	/**
	 * Save the test in the database.
	 */
	public void create(TestModelReport test) {
		em.persist(test);
		return;
	}

	/**
	 * Delete the test from the database.
	 */
	public void delete(TestModelReport test) {
		if (em.contains(test))
			em.remove(test);
		else
			em.remove(em.merge(test));
		return;
	}

	/**
	 * Return all the tests stored in the database.
	 */
	@SuppressWarnings("unchecked")
	public List<TestModelReport> getAll() {
		return em.createQuery("from TestModelReport").getResultList();
	}

	/**
	 * Return the test having the passed email.
	 */
	public TestModelReport getByTestId(String testId) {
		return (TestModelReport) em.createQuery("from TestModelReport where testId = :testId")
				.setParameter("testId", testId).getSingleResult();
	}

	/**
	 * Return the test having the passed id.
	 */
	public TestModelReport getById(long id) {
		return em.find(TestModelReport.class, id);
	}

	/**
	 * Update the passed test in the database.
	 */
	public void update(TestModelReport test) {
		em.merge(test);
		return;
	}

	public void deleteAllByTestId(String testId) {
		Query query = em.createQuery("DELETE FROM TestModelReport WHERE testId = :testId").setParameter("testId", testId);
		query.executeUpdate();
		return;
	}

}
