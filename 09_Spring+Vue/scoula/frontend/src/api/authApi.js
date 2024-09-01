import api from '@/api';

const BASE_URL = '/api/member';
const headers = { 'Content-Type': 'multipart/form-data' };

export default {
  async getList(params) {
    const { data } = await api.get(BASE_URL, { params });
    console.log('AUTH GET LIST: ', data);
    return data;
  },

  async checkUsername(username) {
    const { data } = await api.get(`${BASE_URL}/checkusername/${username}`);
    console.log('AUTH GET CHECKUSERNAME', data);
    return data;
  },

  async get(username) {
    const { data } = await api.get(`${BASE_URL}/${username}`);
    console.log('AUTH GET', data);
    return data;
  },

  async create(member) {
    const formData = new FormData();
    formData.append('username', member.username);
    formData.append('email', member.email);
    formData.append('password', member.password);

    if (member.avatar) {
      formData.append('avatar', member.avatar);
    }

    const { data } = await api.post(BASE_URL, formData, headers);

    console.log('AUTH POST: ', data);
    return data;
  },

  async update(member) {
    const formData = new FormData();
    formData.append('username', member.username);
    formData.append('password', member.password);
    formData.append('email', member.email);

    if (member.avatar) {
      formData.append('avatar', member.avatar);
    }

    const { data } = await api.put(`${BASE_URL}/${member.username}`, formData, headers);
    console.log('AUTH PUT: ', data);
    return data;
  },

  async delete(username) {
    const { data } = await api.delete(`${BASE_URL}/${username}`);
    console.log('AUTH DELETE: ', data);
    return data;
  },

  async changePassword(formData) {
    const { data } = await api.put(`${BASE_URL}/${formData.username}/changepassword`, formData);
    console.log('AUTH PUT: ', data);
    return data;
  },

  async changePassword(formData) {
    const { data } = await api.put(`${BASE_URL}/${formData.username}/changepassword`, formData);
    console.log('AUTH PUT: ', data);

    return data;
  },
};
