import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
  await api
    .post(`/member/login`, JSON.stringify(user))
    .then(success)
    .catch(fail);
}

async function findById(id, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/member/info/${id}`).then(success).catch(fail);
}

async function logout(id, success, fail) {
  await api.get(`/member/logout/${id}`).then(success).catch(fail);
}

async function withdrawal(id, success, fail) {
  await api.get(`/member/withdrawal/${id}`).then(success).catch(fail);
}

async function modify(userInfo, success, fail) {
  console.log("수정 여기");
  await api
    .post(`/member/update`, JSON.stringify(userInfo))
    .then(success)
    .catch(fail);
}

function memberRegister(userInfo, success, fail) {
  api
    .post(`/member/register`, JSON.stringify(userInfo))
    .then(success)
    .catch(fail);
}

export { login, findById, modify, withdrawal, logout, memberRegister };
