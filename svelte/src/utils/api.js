//export const serverAPI = 'https://customer1.enterprise-test.visma.no'
export const serverAPI = 'http://localhost:8080'
const contextPath = '/hrm/api'

export function httpGet(path) {
  return req(path)
}

export function httpPost(path, data) {
  return req(path, 'POST', data)
}

export function httpPut(path, data) {
  return req(path, 'PUT', data)
}

export function httpDelete(path, data) {
  return req(path, 'DELETE', data)
}

async function req(path, method = 'GET', data) {
  const res = await fetch(serverAPI + contextPath + path, {
    method,
    headers: {
      'Content-Type': 'application/json',
    },
    body: data && JSON.stringify(data),
  })
  const json = await res.json()
  return { ok: res.ok, data: json }
}
