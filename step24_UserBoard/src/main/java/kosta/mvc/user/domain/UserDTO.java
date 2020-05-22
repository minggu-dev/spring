package kosta.mvc.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	private String userId;
	private String pwd;
	private String name;
}
