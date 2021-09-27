package adapter.id_generator.uuid;

import usecase.port.IdGenerator;

import java.util.UUID;

public class UuidGenerator implements IdGenerator {

	@Override
	public String generate() {
		return UUID.randomUUID().toString();
	}
}
