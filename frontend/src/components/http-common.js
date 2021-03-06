import axios from 'axios'

export const AXIOS = axios.create({
  baseURL: `http://localhost:8080/api`,
  headers: {
      'Access-Control-Allow-Origin': 'http://localhost:8080',
      'Access-Control-Allow-Methods': 'POST,GET, OPTIONS, DELETE',
      'Access-Control-Allow-Headers': '*'
    }
  })