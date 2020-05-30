--
-- Structure de la table `order_item`
--

CREATE TABLE `order_item` (
                              `id` bigint(20) NOT NULL,
                              `price` double NOT NULL,
                              `quantity` int(11) NOT NULL,
                              `book_id` bigint(20) DEFAULT NULL,
                              `order_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `order_item`
--
ALTER TABLE `order_item`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKb033an1f8qmpbnfl0a6jb5njs` (`book_id`),
  ADD KEY `FKt4dc2r9nbvbujrljv3e23iibt` (`order_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `order_item`
--
ALTER TABLE `order_item`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;
