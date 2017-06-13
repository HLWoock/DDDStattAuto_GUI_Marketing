package de.woock.ddd.stattauto.gui.backoffice;

import java.awt.EventQueue;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import de.woock.ddd.stattauto.gui.backoffice.views.TabView;

@SpringBootApplication
public class DddStattAuto_Gui_Marketing {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DddStattAuto_Gui_Marketing.class).headless(false)
                                                                                .web(false)
                                                                                .run(args);
	}
	
	@Bean 
	public CommandLineRunner demo(TabView gui) {
		return (args) -> {
			EventQueue.invokeLater(() -> gui.setVisible(true));
		};
	}

}
