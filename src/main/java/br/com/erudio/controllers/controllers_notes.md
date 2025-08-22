# @RestController
@RestController é uma abstração de duas annotations:
- @Controller: Servir páginas
- @ResponseBody: Servir JSON ou XML
Poderia substituir pelas duas se quisesse.
É possível clicar com CTRL+Click para abrir a RestController e ver.

 ## Questions 
- Servir?

# @RequestMapping("/endpoint")
Para que o método seja reconhecido como exposto para HTTP.
No futuro existem soluções mais inteligentes para o RequestMapping, mas é muito utilizado em legado.
Ex: http://localhost:8080/endpoint?parametro=teste

# String template
"Hello, %s!", onde %s será substituido pelo parametro enviado na requisição HTTP

# @RequestParam(value="paramName", defaultValue="defaultValue")
Possibilita que o método leia o parâmetro vindo da requisição

# @ControllerAdvice
Se aplica a todos os controllers