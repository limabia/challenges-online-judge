A rotina PathR é bem conhecida em grafos. É também chamada de dfs ou dfsr. Trata-se de uma busca em profundidade dos nodos do grafo, utilizando backtracking. A tarefa aqui é, dado o grafo de entrada, simplesmente gerar o desenho da hierarquia dos nodos pesquisados.


# Entrada
A entrada será um arquivo contendo vários casos de teste. A primeira linha do arquivo de entrada contém um inteiro N que indica a quantidade de casos de teste que vem a seguir. Cada um dos N casos de teste contém, na primeira linha, duas informações: V (1 ≤ V ≤ 20) e E (1 ≤ E ≤ 20) que são, respectivamente, a quantidade de Vértices e de Arestas (Edges) do grafo. Seguem  E linhas contendo informações sobre cada uma das arestas do grafo.

# Saída
Para cada caso de entrada, deve ser apresentada uma saída que representa a busca em profundidade de todos os nodos,  respeitando a hierarquia e profundidade de cada um deles. O símbolo b  representam um espaço em branco. Veja o exemplo abaixo para ilustrar:
bb0-2 pathR(G,2)

bbbb2-1 pathR(G,1)

bbbb2-4 pathR(G,4)

bbbbbb4-1

E assim sucessivamente...
Obs.: Há uma linha em branco depois de cada segmento impresso do grafo, inclusive após o último segmento.

