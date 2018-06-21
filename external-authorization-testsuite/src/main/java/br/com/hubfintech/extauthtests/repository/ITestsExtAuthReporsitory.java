package br.com.hubfintech.extauthtests.repository;

import java.util.List;

import br.com.hubfintech.extauthtests.model.TestModelReport;

public interface ITestsExtAuthReporsitory {

	public void create(TestModelReport user);

	public void delete(TestModelReport user);

	public List<TestModelReport> getAll();

	public TestModelReport getByTestId(String testId);

	public TestModelReport getById(long id);

	public void update(TestModelReport test);

	public void deleteAllByTestId(String testId);

}
