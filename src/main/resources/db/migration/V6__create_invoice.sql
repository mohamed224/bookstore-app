--
-- Structure de la table `invoice`
--

CREATE TABLE `invoice` (
                           `id` bigint(20) NOT NULL,
                           `date` datetime DEFAULT NULL,
                           `is_bill_paid` bit(1) NOT NULL,
                           `order_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `invoice`
--
ALTER TABLE `invoice`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKthf5w8xuexpjinfl7xheakhqn` (`order_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `invoice`
--
ALTER TABLE `invoice`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;
