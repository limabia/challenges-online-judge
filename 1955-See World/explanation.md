Podemos representar esse problema através de um grafo, onde caso as orcas compartilhem um dialeto em comum, há uma aresta entre elas.

Com a representação em grafo, esse problema consiste em identificar o número de subgrafos completo existentes nele. Se o número de subgrafos for maior que 2, então não há uma combinação aceitável.

Para facilitar o algoritmo, construímos um grafo através de lista de adjacência, mas também mantemos a matriz.

O problema para encontrar todos os subgrafos completos é NP completo e existem alguns algoritmos para resolvê-lo. 

Porém, decidimos utilizar um algoritmo iterativo onde verificamos cada subgrupo possível para cada nó do grafo.

Os passos do algoritmo para resolver o problema são:

Para cada nó do grafo disponível, faça:

- Marque ele como não verificado.

- Para cada nó adjacente disponível, verifique se ele possui conexão com todos os nós adjacentes disponíveis e não verificados ainda.
- Se sim, identifica esse nó como indisponível (já faz parte de um grupo)
- Se não, marca o nó como já verificado.

- Incrementa o número de grupos.

- Se o número de grupos for maior que 2, pare o laço.

Ao final do algoritmos teremos a quantidade de grupos formados, sendo que se for maior que 2 paramos ali.
