package com.rsm;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Files;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestTypescriptApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Inject
	RepositoryRestMvcConfiguration configuration;

	@Inject
	private MockMvc mockMvc; 

	@Test
	public void getEndPoints() {
		configuration.resourceMappings().forEach(c -> {

			String className = c.getDomainType().getName();

			try {
				Class<?> entityClass = Class.forName(className);

				Field[] fields = entityClass.getDeclaredFields();

				File tsClassDir = new File("data/tsClass");
				File tsClass = new File(tsClassDir, entityClass.getSimpleName() + ".ts");

				if (!tsClassDir.getParentFile().exists()) {
					tsClass.getParentFile().mkdirs();
				}

				tsClass.createNewFile();

				String code = "export interface " + entityClass.getSimpleName() + "{\n";

				for (Field field : fields) {
					try {
						Class<?> fieldClass = Class.forName(field.getType().getName());
						code += "\t" + field.getName() + ": " + fieldClass.getSimpleName() + ";" + "\n";
					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				code += "}";

				Files.write(tsClass.toPath(), code.getBytes());
				System.err.println(code);
			} catch (Exception e) {
				// TODO: handle exception
			}
		});
	}

	@Test
	public void initializing() throws Exception {
		this.mockMvc.perform(get("/users")).accept(MediaType.TEXT_PLAIN)
					.andExpect(status().isOk());

	}
}
