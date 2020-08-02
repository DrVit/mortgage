package ru.geekbrains.mortgage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.geekbrains.mortgage.entity.MortgageApplication;
import ru.geekbrains.mortgage.entity.ResolutionStatus;
import ru.geekbrains.mortgage.repository.MortgageApplicationRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MortgageApplicationTests {

	@Autowired
	private MortgageApplicationRepository repository;

	@BeforeEach
	public void setUp(){
		repository.deleteAll();

		List<MortgageApplication> applicationList = Arrays.asList(
				new MortgageApplication("Fedor Prokofyev", ResolutionStatus.TERRORIST),
				new MortgageApplication("Peter Sergeev", ResolutionStatus.SUCCESSFUL),
				new MortgageApplication("Faina Sergeeva", ResolutionStatus.SUCCESSFUL),
				new MortgageApplication("Olga Bukina", ResolutionStatus.SUCCESSFUL),
				new MortgageApplication("Natalya Rostova", ResolutionStatus.SUCCESSFUL)
		);
		repository.saveAll(applicationList);
	}

	@Test
	void contextLoads() {
		List<MortgageApplication> all = repository.getAllByStatusEquals(ResolutionStatus.TERRORIST);
		Assertions.assertThat(all.size() == 1);
	}

}
