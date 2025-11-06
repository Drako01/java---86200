package com.coderhouse.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.coderhouse.interfaces.CRUDRESTInterfaces;
import com.coderhouse.models.User;

@Component
public class UserRestApi implements CRUDRESTInterfaces<User, String> {

	private final String BASE_URL = "https://690d160ea6d92d83e8506e8b.mockapi.io/user";

	private final String errorMessage = "Error, No se pueden obtener los datos del Servidor";

	@Autowired
	private RestTemplate rt;

	@Override
	public List<User> getAll() {
		try {
			@SuppressWarnings("unchecked")
			List<User> users = rt.exchange(BASE_URL, HttpMethod.GET, null, List.class).getBody();
			return users;
		} catch (Exception e) {
			throw new RuntimeException(errorMessage + ", " + e.getMessage());
		}
	}

	@Override
	public User getById(String id) {
		try {
			String url = BASE_URL + "/" + id;
			return rt.getForObject(url, User.class);
		} catch (HttpClientErrorException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(errorMessage + ", " + e.getMessage());
		}
	}

	@Override
	public User create(User user) {
		try {
			return rt.postForObject(BASE_URL, user, User.class);
		} catch (Exception e) {
			throw new RuntimeException(errorMessage + ", " + e.getMessage());
		}
	}

	@Override
	public User update(User user) {
		try {
			String url = BASE_URL + "/" + user.getId();
			rt.put(url, user);
			return user;
		} catch (Exception e) {
			throw new RuntimeException(errorMessage + ", " + e.getMessage());
		}
	}

	@Override
	public void deleteById(String id) {
		try {
			String url = BASE_URL + "/" + id;
			rt.delete(url);
		} catch (Exception e) {
			throw new RuntimeException(errorMessage + ", " + e.getMessage());
		}

	}

}
