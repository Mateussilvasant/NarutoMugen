package br.com.narutomugen.game.events.player;

import br.com.narutomugen.game.entities.character.Personagem;
import br.com.narutomugen.game.events.TecladoEvent;

public class Jogador {
	public Personagem personagem;
	private String comandos[];
	private TecladoEvent tecladoEvent;

	public Jogador(Personagem personagem, TecladoEvent event, ETipoControle eTipoControle) {
		setPersonagem(personagem);
		comandos = eTipoControle.getComandos();
		tecladoEvent = event;
	}

	public void atualizarMecanicas(double delta) {
		capturarComando();
		personagem.atualizarMecanicas(delta);
	}

	public void atualizarAnimacoes(double delta) {
		personagem.atualizarAnimacoes(delta);
	}

	private void capturarComando() {
		if (tecladoEvent.pressionou(comandos[0])) {
			personagem.correrParaDireita();
		}

		if (tecladoEvent.pressionou(comandos[1])) {
			personagem.correrParaEsquerda();
		}

		if (tecladoEvent.pressionou(comandos[2])) {
			personagem.pularParaCima();
		}

		if (tecladoEvent.pressionou(comandos[3])) {
			personagem.executarPoder_1();
		}

		if (tecladoEvent.semComando()) {
			personagem.parar();
		}

	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

}
