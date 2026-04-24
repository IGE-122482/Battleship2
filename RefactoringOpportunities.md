# Refactoring Opportunities
| Local (classe::método) | Code Smell | Refabricação | Nº Aluno |
|---|---|---|---|
| Game::printBoard | Long Method | Extract Method (extrair renderização do mapa) | 122478 |
| Game::printBoard | Long Method | Extract Method (extrair impressão da legenda) | 122478 |
| Game::printBoard | Long Method | Extract Method (extrair impressão do cabeçalho das colunas) | 122478 |
| Game::jsonShots | Long Method | Extract Method (extrair criação da lista simplificada de tiros) | 122478 |
| ResultadoJogo | Data Class | Encapsulate Fields (tornar campos privados) | 122478 |
| Game::randomEnemyFire | Long Method | Extract Method (extrair geração de posições candidatas) | 122457 |
| Game::randomEnemyFire | Long Method | Extract Method (extrair lógica de seleção dos tiros) | 122457 |
| Game::readEnemyFire | Long Method | Extract Method (extrair parsing de uma posição do scanner) | 122457 |
| Game::readEnemyFire | Long Method | Extract Method (extrair validação de posição) | 122457 |
| Carrack | Duplicated Code | Extract Method (unificar cases NORTH/SOUTH e EAST/WEST no switch) | 122457 |
| Move::processEnemyFire | Long Method | Extract Method (extrair construção da mensagem verbose) | 122488 |
| Move::processEnemyFire | Long Method | Extract Method (extrair contagem dos resultados dos tiros) | 122488 |
| Move::processEnemyFire | Long Method | Extract Method (extrair serialização do JSON de resposta) | 122488 |
| Frigate | Duplicated Code | Extract Method (unificar cases NORTH/SOUTH e EAST/WEST no switch) | 122488 |
| Fleet::getFloatingShips | Duplicated Code | Extract Method (unificar com getSunkShips usando um predicado) | 122488 |
| Game::fireShots | Long Method | Extract Method (extrair criação e registo do Move) | 122482 |
| Fleet::colisionRisk | Long Method | Replace Loop with Stream (substituir for por stream com anyMatch) | 122482 |
| ExportadorResultados::guardarResultado | Long Method | Extract Method (extrair tratamento do catch) | 122482 |
| Carrack | Duplicated Code | Rename (renomear variáveis de loop para maior clareza) | 122482 |
| Game | Long Method | Rename (renomear countInvalidShots, countRepeatedShots para nomes mais expressivos) | 122482 |
