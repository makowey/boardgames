package info.makowey.boardgames.chilipir.service;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.repository.BoardGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectorServiceImpl implements CollectorService {

	private final BoardGameRepository boardGameRepository;

	@Autowired
	public CollectorServiceImpl( BoardGameRepository boardGameRepository ) {
		this.boardGameRepository = boardGameRepository;
	}

	@Override
	public List<BoardGame> traceAll() {
		return boardGameRepository.findAll();
	}
}
