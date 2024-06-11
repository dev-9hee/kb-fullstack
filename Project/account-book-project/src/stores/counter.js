import { ref, computed, reactive } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

const BASE_URL = 'http://localhost:3000/manageList';

export const useMoneyManageStore = defineStore('moneyManageStore', () => {
  const states = reactive({
    manageList: [],
  });

  async function fetchMoneyManageList() {
    try {
      const fetchMoneyManageListRes = await axios.get(BASE_URL);

      states.manageList = fetchMoneyManageListRes.data;
    } catch (e) {
      alert('moneylist 통신 오류 발생');
      console.log(e);
    }
  }

  async function addMoneyEntry(entry) {
    try {
      await axios.post(BASE_URL, entry);
      fetchMoneyManageList();
    } catch (e) {
      alert('추가 작업 중 오류 발생');
      console.log(e);
    }
  }

  async function saveMoney(
    year,
    month,
    day,
    amount,
    memo,
    category,
    isDeposit
  ) {
    const newEntry = {
      year,
      month,
      day,
      amount: isDeposit ? amount : -amount, // 양수 또는 음수로 저장
      memo,
      category,
      date: `${year}-${String(month).padStart(2, '0')}-${String(day).padStart(
        2,
        '0'
      )}`,
    };
    await addMoneyEntry(newEntry);
  }

  return {
    states,
    fetchMoneyManageList,
    saveMoney,
  };
});
