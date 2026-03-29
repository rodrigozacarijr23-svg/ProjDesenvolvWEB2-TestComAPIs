const APIUsuarios = "http://localhost:8082/myproject/api/v1";
const APIPlanilhas = "http://localhost:8081/myproject/api/v1";

// Função para alternar abas
function openTab(tabId) {
    document.querySelectorAll('.tabcontent').forEach(c => c.classList.remove('active'));
    document.getElementById(tabId).classList.add('active');

    document.querySelectorAll('.tablink').forEach(t => t.classList.remove('active'));
    document.querySelector(`.tablink[onclick="openTab('${tabId}')"]`).classList.add('active');

    document.getElementById("resultado").innerHTML = "";
}

// Função mostrarResultado com opção JSON / Tabela
function mostrarResultado(data) {
    const tipoSaida = document.querySelector('input[name="saida"]:checked')?.value || 'json';
    const resultado = document.getElementById("resultado");

    resultado.innerHTML = '';
    resultado.className = '';

    if (tipoSaida === 'json') {
        resultado.classList.add('json');
        resultado.innerHTML = `<pre>${JSON.stringify(data, null, 2)}</pre>`;
        return;
    }

    resultado.classList.add('tabela'); // Classe para CSS se quiser

    function renderObject(obj, nomeObjeto = '', indent = 0) {
        let html = '';
        const pad = '&nbsp;'.repeat(indent * 4); // Indentação

        if (nomeObjeto) html += `<h4>${nomeObjeto}</h4>`;

        for (const key in obj) {
            if (!obj.hasOwnProperty(key)) continue;
            const val = obj[key];
            if (val && typeof val === 'object' && !Array.isArray(val)) {
                html += `<strong>${pad}${capitalize(key)}:</strong><br>`;
                html += renderObject(val, '', indent + 1);
            } else {
                html += `${pad}${capitalize(key)}: ${val ?? '<i>null</i>'}<br>`;
            }
        }

        return html;
    }

    function capitalize(str) {
        return str.charAt(0).toUpperCase() + str.slice(1);
    }

    if (Array.isArray(data)) {
        let html = '';
        data.forEach((item, index) => {
            const nomeObjeto = `Objeto ${index + 1}`;
            html += renderObject(item, nomeObjeto);
            html += '<hr>'; // Separador entre objetos
        });
        resultado.innerHTML = html;
    } else if (typeof data === 'object' && data !== null) {
        resultado.innerHTML = renderObject(data);
    } else {
        resultado.innerHTML = `<p>${data}</p>`;
    }
}

// ================== USUÁRIO ==================
async function criarUsuario() {
    const nome = document.getElementById("nomeUsuario").value.trim();
    const telefone = document.getElementById("telefoneUsuario").value.trim();
    const logradouro = document.getElementById("logradouroUsuario").value.trim();
    const numero = document.getElementById("numeroUsuario").value.trim();
    const bairro = document.getElementById("bairroUsuario").value.trim();
    const cidade = document.getElementById("cidadeUsuario").value.trim();
    const cep = document.getElementById("cepUsuario").value.trim();

    if (!nome || !telefone || !logradouro || !numero || !bairro || !cidade || !cep) {
        alert("❌ Todos os campos do usuário e endereço devem ser preenchidos!");
        return;
    }

    const usuario = {
        nome,
        telefone,
        endereco: { logradouro, numero, bairro, cidade, cep }
    };

    try {
        const response = await fetch(`${APIUsuarios}/usuarios`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(usuario)
        });

        const data = await response.json();

        if (data.id) {
            document.getElementById("usuarioId").value = data.id;
        }

        mostrarResultado(data);

    } catch (err) {
        console.error(err);
        alert("❌ Erro ao criar usuário. Verifique se a API está rodando e a rota está correta.");
    }
}

// ================== PLANILHA ==================
async function criarPlanilha() {
    const nome = document.getElementById("nomePlanilha").value.trim();
    const tamArquivo = Number(document.getElementById("tamArquivo").value);
    const linhas = document.getElementById("linhas").value;
    const colunas = document.getElementById("colunas").value;
    const usuarioId = document.getElementById("usuarioId").value.trim();

    if (!nome || !linhas || !colunas || !usuarioId) {
        alert("❌ Todos os campos da planilha devem ser preenchidos!");
        return;
    }

    try {
        const response = await fetch(`${APIPlanilhas}/planilha`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                nomePlanilha: nome,
                tamanhoArquivo: Number(tamArquivo),
                qtdLinhas: Number(linhas),
                qtdColunas: Number(colunas),
                usuarioCadastrado: { id: usuarioId },
                status: true
            })
        });

        mostrarResultado(await response.json());

        // =================== PREENCHIMENTO AUTOMÁTICO DOS CAMPOS DE COMPARAÇÃO ===================
        const planilha1 = document.getElementById("planilha1");
        const planilha2 = document.getElementById("planilha2");

        // Se o campo 1 estiver vazio, coloca nele
        if (!planilha1.value) {
            planilha1.value = data.id;
        } 
        // Se o campo 1 estiver cheio e campo 2 vazio, coloca no campo 2
        else if (!planilha2.value) {
            planilha2.value = data.id;
        }
        // Se ambos estiverem preenchidos, não faz nada

    } catch (err) {
        console.error(err);
        alert("❌ Erro ao criar planilha");
    }
}

// ================== COMPARAÇÃO ==================
async function criarComparacao() {
    const id1 = document.getElementById("planilha1").value.trim();
    const id2 = document.getElementById("planilha2").value.trim();

    if (!id1 || !id2) {
        alert("❌ Preencha os IDs das planilhas para comparar!");
        return;
    }

    try {
        const response = await fetch(`${APIPlanilhas}/comparacao-planilha`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                planilhaInicial: { id: id1 },
                planilhaComparacao: { id: id2 },
                descricao: "Comparação via HTML",
                status: true
            })
        });

        mostrarResultado(await response.json());

        // =================== LIMPAR CAMPOS APÓS COMPARAÇÃO ===================
        document.getElementById("planilha1").value = "";
        document.getElementById("planilha2").value = "";

    } catch (err) {
        console.error(err);
        alert("❌ Erro ao criar comparação");
    }
}

// ================== LISTAR ==================
// ================== HISTÓRICO ==================
async function listarHistorico() {
    try {
        const response = await fetch(`${APIPlanilhas}/historico`);
        mostrarResultado(await response.json());
    } catch (err) {
        console.error(err);
        alert("❌ Erro ao listar histórico de comparações");
    }
}

async function buscarHistoricoPorId(id) {
    if (!id) {
        alert("❌ Informe o ID do histórico");
        return;
    }
    try {
        const response = await fetch(`${APIPlanilhas}/historico/${id}`);
        mostrarResultado(await response.json());
    } catch (err) {
        console.error(err);
        alert("❌ Erro ao buscar histórico por ID");
    }
}

// ================== SCORE ==================
async function listarScores() {
    try {
        const response = await fetch(`${APIPlanilhas}/score`);
        mostrarResultado(await response.json());
    } catch (err) {
        console.error(err);
        alert("❌ Erro ao listar scores");
    }
}

async function buscarScorePorId(id) {
    if (!id) {
        alert("❌ Informe o ID do score");
        return;
    }
    try {
        const response = await fetch(`${APIPlanilhas}/score/${id}`);
        mostrarResultado(await response.json());
    } catch (err) {
        console.error(err);
        alert("❌ Erro ao buscar score por ID");
    }
}

// ================== USUÁRIO ==================
async function listarUsuarios() {
    try {
        const response = await fetch(`${APIUsuarios}/usuarios`);
        mostrarResultado(await response.json());
    } catch (err) {
        console.error(err);
        alert("❌ Erro ao listar usuários");
    }
}

async function buscarUsuarioPorId(id) {
    if (!id) {
        alert("❌ Informe o ID do usuário");
        return;
    }
    try {
        const response = await fetch(`${APIUsuarios}/usuarios/${id}`);
        mostrarResultado(await response.json());
    } catch (err) {
        console.error(err);
        alert("❌ Erro ao buscar usuário por ID");
    }
}

// ================== COMPARAÇÕES ==================
async function listarComparacoes() {
    try {
        const response = await fetch(`${APIPlanilhas}/comparacao-planilha`);
        mostrarResultado(await response.json());
    } catch (err) {
        console.error(err);
        alert("❌ Erro ao listar comparações");
    }
}

async function buscarComparacaoPorId(id) {
    if (!id) {
        alert("❌ Informe o ID da comparação");
        return;
    }
    try {
        const response = await fetch(`${APIPlanilhas}/comparacao-planilha/${id}`);
        mostrarResultado(await response.json());
    } catch (err) {
        console.error(err);
        alert("❌ Erro ao buscar comparação por ID");
    }
}

// ================== UTIL ==================
function mostrarResultado(data) {
    document.getElementById("resultado").innerText =
        JSON.stringify(data, null, 2);
}