import axios from "axios";
import { API_BASE_URL, APT_DEAL_URL, CORONA_HOSPITAL_URL, STORE_LIST_URL } from "@/config";

// axios 객체 생성
function apiInstance() {
  const instance = axios.create({
    baseURL: API_BASE_URL,
    headers: {
      "Content-type": "application/json",
    },
  });
  return instance;
}

function houseInstance() {
  const instance = axios.create({
    baseURL: APT_DEAL_URL,
    headers: {
      "Content-type": "application/json",
    },
  });
  return instance;
}

function hospitalInstance() {
    const instance = axios.create({
      baseURL: CORONA_HOSPITAL_URL,
      headers: {
        "Content-type": "application/json",
      },
    });
    return instance;
}
  
function storeInstance() {
    const instance = axios.create({
      baseURL: STORE_LIST_URL,
      headers: {
        "Content-type": "application/json",
      },
    });
    return instance;
}

export { apiInstance, houseInstance, hospitalInstance, storeInstance };
