Primeiro construímos um grafo utilizando lista de adjacência. 

O Grafo construído possui as seguintes propriedades:

- Lista de adjacência: guarda todas as arestas para cada nó
- Array de distância: indica qual a distância de cada nó para o nó de origem
- Array de visitados: indica se o nó já foi visitado ou não
- Array de origem: indica qual o caminho feito até cada nó

Visto que as arestas são bidirecionais, inserimos duas arestas para cada uma da entrada do problema.

Para resolver o problema, utilizamos o algoritmo de Djikstra para encontrar o menor caminho entre dois nós em um grafo. 
Optamos por esse algoritmo pois não existem arestas com pesos negativos e ele garante que será encontrado o menor caminho em um tempo razoável.

Na implementação do Djikstra, utilizamos uma fila de prioridade do Java para sempre seguir para o seguinte nó com a menor distância.

A parte mais difícil não foi identificar a técnica escolhida, mas sim implementá-la. Tivemos que criar diversas classes e estruturas para 
poder aplicar o algoritmo, como implementar o método de comparação da fila de prioridade e decidir quando inserir ou alterar um elemento 
da fila.

No princípio estávamos utilizando o array de distância para saber de um nó foi visitado ou não, mas para facilitar na alteração 
dos elementos já inseridos na fila de prioridade, criamos um array de visitados e passamos a utilizar o array de distância para 
calcular quando ele deveria ser alterado ou não. 
