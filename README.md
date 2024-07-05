# Mochito
## Mocks vs stubs
- stub: apenas prove respostas prontas para chamadas que seram feitas durante teste
  - Se o teste invocar o método A, retorno B. 
  - Se o teste invocar o método X, retorno Y.
- mock: vai além de prover respostas, tambem valida as chamadas
  - O teste deve invocar primeiro o método A, passando o valor 1 como parâmetro, daí retorno B. 
  - O teste deve depois invocar o método X, passando o valor 2 como parâmetro, daí retorno Y.
  - Se o teste não seguir exatamente esta sequência, ele falha.

# Spy
- referencia objeto real de classe e "espiona" ela