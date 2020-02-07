package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Methods Test")
public class SetTest {
	private Set numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
	}

	@Test
	@DisplayName("size() works properly")
	void size() {
		assertThat(numbers).hasSize(4);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("contains() works properly")
	void contains(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:false"}, delimiter = ':')
	@DisplayName("contains() works properly within several values")
	void containsWithSeveralConditions(int number, boolean expected) {
		assertThat(numbers.contains(number)).isEqualTo(expected);
	}
}
