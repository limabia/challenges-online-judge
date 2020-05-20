# -*- coding: utf-8 -*-

# Bianca Lima Santos - 10346811
n = int(input())
dicionario = {}
caso = 0
count = 0


def imprime_resultado():
    if count:
        if caso > 1:
            print()
        for arvore in sorted(dicionario):
            percentual = dicionario[arvore]/count * 100
            print("%s %.4f" % (arvore, percentual))

while True:
    try:
        especie = input()
        if not especie:
            imprime_resultado()

            caso += 1
            if caso > n:
                exit()
            dicionario = {}
            count = 0
        else:
            if especie in dicionario:
                dicionario[especie] += 1
            else:
                dicionario[especie] = 1
            count += 1
    except EOFError:
        imprime_resultado()
        exit()
