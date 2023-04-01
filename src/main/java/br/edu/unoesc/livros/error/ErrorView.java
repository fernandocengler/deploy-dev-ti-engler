package br.edu.unoesc.livros.error;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ErrorView implements ErrorViewResolver {

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {
		System.out.println("---------");
		map.forEach((chave, valor) -> System.out.println(chave + ": " + valor));
		System.out.println("---------");

		ModelAndView model = new ModelAndView("/error");
		model.addObject("status", status.value());

		switch (status.value()) {
		case 404:
			model.addObject("error", "Pagina não encontrada");
			model.addObject("message", "A URL para pagina '" + map.get("path") + " 'não exite");

			break;
		case 500:
			break;

		}

		return null;
	}

}